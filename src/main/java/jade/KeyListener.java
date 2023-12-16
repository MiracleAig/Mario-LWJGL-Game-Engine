package jade;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class KeyListener {

    private static KeyListener instance;
    private boolean keyPresssed[] = new boolean[350];

    private KeyListener(){

    }

    public static KeyListener get(){
        if(KeyListener.instance == null){
            KeyListener.instance = new KeyListener();
        }

        return KeyListener.instance;
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods){
        if(action == GLFW_PRESS){
            get().keyPresssed[key] = true;
        } else if (action == GLFW_RELEASE){
            get().keyPresssed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode){
        if(keyCode < get().keyPresssed.length){
            return get().keyPresssed[keyCode];
        } else {
            return false;
        }
    }


}
