import model.Design;
import model.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveState {
    public Map<String, Design> designMap = new HashMap<>();
    public List<File> fileSystemRoot = new ArrayList<>();
    public Options options = new Options();
    public MissionControl missionControl = new MissionControl();

    public static class Options {
        Integer colorMode;
        Boolean soundMute;
        Integer dispMode;

        @Override
        public String toString() {
            return "Options{" +
                    "colorMode=" + colorMode +
                    ", soundMute=" + soundMute +
                    ", dispMode=" + dispMode +
                    '}';
        }
    }

    public static class MissionControl {
        Boolean multiLogicCompleted;
        Boolean multiOrCompleted;
        Boolean multiNotCompleted;
        Boolean muxesCompleted;
        Boolean demuxesCompleted;
        Boolean adderCompleted;
        Boolean aluCompleted;
        Boolean registerCompleted;
        Boolean ramCompleted;
        Boolean counterCompleted;
        Boolean introducedTed;

        @Override
        public String toString() {
            return "MissionControl{" +
                    "multiLogicCompleted=" + multiLogicCompleted +
                    ", multiOrCompleted=" + multiOrCompleted +
                    ", multiNotCompleted=" + multiNotCompleted +
                    ", muxesCompleted=" + muxesCompleted +
                    ", demuxesCompleted=" + demuxesCompleted +
                    ", adderCompleted=" + adderCompleted +
                    ", aluCompleted=" + aluCompleted +
                    ", registerCompleted=" + registerCompleted +
                    ", ramCompleted=" + ramCompleted +
                    ", counterCompleted=" + counterCompleted +
                    ", introducedTed=" + introducedTed +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SaveState{" +
                "designMap=" + designMap +
                ", fileSystemRoot=" + fileSystemRoot +
                ", options=" + options +
                ", missionControl=" + missionControl +
                '}';
    }

    public static SaveState load(String filename) throws IOException, ClassNotFoundException {
        var state = new SaveState();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            state.designMap = (Map<String, Design>) ois.readObject();
            state.fileSystemRoot = (List<File>) ois.readObject();
            state.options.colorMode = (Integer) ois.readObject();
            state.options.soundMute = (Boolean) ois.readObject();
            state.missionControl.multiLogicCompleted = (Boolean) ois.readObject();
            state.missionControl.multiOrCompleted = (Boolean) ois.readObject();
            state.missionControl.multiNotCompleted = (Boolean) ois.readObject();
            state.missionControl.muxesCompleted = (Boolean) ois.readObject();
            state.missionControl.demuxesCompleted = (Boolean) ois.readObject();
            state.missionControl.adderCompleted = (Boolean) ois.readObject();
            state.missionControl.aluCompleted = (Boolean) ois.readObject();
            state.missionControl.registerCompleted = (Boolean) ois.readObject();
            state.missionControl.ramCompleted = (Boolean) ois.readObject();
            state.missionControl.counterCompleted = (Boolean) ois.readObject();
            state.missionControl.introducedTed = (Boolean) ois.readObject();
            state.options.dispMode = (Integer) ois.readObject();
        }
        return state;
    }
}
