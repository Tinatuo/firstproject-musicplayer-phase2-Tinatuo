package com.example.spotify4.View;

import javafx.scene.Scene;

public class SceneStack {
    public static SceneStack sceneStack=new SceneStack();

   private Scene[] scenes=new Scene[15];

    public Scene[] getScenes() {
        return scenes;
    }

    private int currentSceneIndex=-1;

    public int getCurrentSceneIndex() {
        return currentSceneIndex;
    }

    public void push(Scene scene) {
        currentSceneIndex++;
        scenes[currentSceneIndex]=scene;
    }
    public Scene pop() {
        currentSceneIndex--;
        Scene scene=scenes[currentSceneIndex];
        return scene;
    }
}
