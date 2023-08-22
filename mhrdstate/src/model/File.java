package model;

import java.io.Serializable;

public interface File extends Serializable {

   String getName();
   String toString(boolean last);
}
