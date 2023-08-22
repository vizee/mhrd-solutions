import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static void outputCode(String name, String code, String dir) throws IOException {
        code = code.strip() + "\n";
        if (dir.isEmpty()) {
            System.out.println("// " + name + "\n" + code);
        } else {
            try (var fw = new FileWriter(dir + name + ".txt")) {
                fw.write(code);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filename = "./userdata/savestate";
        boolean all = false;
        boolean debug = false;
        String outdir = "";
        var argi = 0;
        while (argi < args.length) {
            var match = false;
            switch (args[argi]) {
                case "-f" -> {
                    argi++;
                    filename = args[argi];
                    match = true;
                }
                case "-all" -> {
                    all = true;
                    match = true;
                }
                case "-debug" -> {
                    debug = true;
                    match = true;
                }
                case "-out" -> {
                    argi++;
                    outdir = args[argi];
                    match = true;
                }
            }
            if (!match) {
                break;
            }
            argi++;
        }

        var state = SaveState.load(filename);

        if (debug) {
            System.out.println(state);
        }

        if (!outdir.isEmpty()) {
            if (outdir.charAt(outdir.length() - 1) != '/') {
                outdir = outdir + "/";
            }
        }

        if (all) {
            String dir = outdir;
            state.designMap.forEach((name, design) -> {
                if (design.code != null) {
                    try {
                        outputCode(name, design.code, dir);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } else {
            while (argi < args.length) {
                var design = state.designMap.get(args[argi]);
                if (design.code != null) {
                    outputCode(args[argi], design.code, outdir);
                }
                argi++;
            }
        }
    }
}
