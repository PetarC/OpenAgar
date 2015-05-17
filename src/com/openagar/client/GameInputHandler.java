package com.openagar.client;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class GameInputHandler {
    private GLFWKeyCallback keyCallback;
    private GLFWCursorPosCallback cursorPosCallback;

    public GameInputHandler() {
        keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scanCode, int action, int mods) {
                onKeyPress(window, key, scanCode, action, mods);
            }
        };

        cursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double x, double y) {
                onCursorMove(window, x, y);
            }
        };
    }

    public void listen(long window) {
        glfwSetKeyCallback(window, keyCallback);
        glfwSetCursorPosCallback(window, cursorPosCallback);
    }

    public void release() {
        keyCallback.release();
        cursorPosCallback.release();
    }

    public void onKeyPress(long window, int key, int scanCode, int action, int mods) {
        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
            glfwSetWindowShouldClose(window, GL_TRUE);
            return;
        }

        if (key == GLFW_KEY_F1 && action == GLFW_RELEASE) {
            glfwSetWindowTitle(window, "OpenAgar, Half-Life 3 confirmed");
            return;
        }
    }

    public void onCursorMove(long window, double x, double y) {
        glfwSetWindowTitle(window, Client.NAME + " [X: "+ x +", Y: "+ y +"]");
    }
}
