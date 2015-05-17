package com.openagar.client;

import org.lwjgl.Sys;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import java.nio.ByteBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GameWindow {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private long window;
    private GameInputHandler inputHandler;

    public void run() {
        System.out.println("Starting a GameWindow with LWJGL "+ Sys.getVersion());

        try {
            /* Prepare the window */
            prepareWindow();

            /* Render the window in a loop */
            renderWindow();

            /* Release the window */
            glfwDestroyWindow(window);

            /* Release input handler */
            inputHandler.release();
        }
        finally {
            /* Terminate GLFW */
            glfwTerminate();
        }

        System.out.println("Terminating a GameWindow");
    }

    private void prepareWindow() {
        /* Initialize GLFW */
        if (glfwInit() != GL11.GL_TRUE)
            throw new IllegalStateException("Could not initialize GLFW");

        /* Prepare window hints */
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

        /* Create the window */
        window = glfwCreateWindow(WIDTH, HEIGHT, Client.NAME, NULL, NULL);

        if (window == NULL)
            throw new RuntimeException("Could not create a GameWindow");

        /* Create an input handler */
        inputHandler = new GameInputHandler();
        inputHandler.listen(window);

        /* Resolution of the primary monitor */
        ByteBuffer byteBuffer = glfwGetVideoMode(glfwGetPrimaryMonitor());

        /* Center the window */
        glfwSetWindowPos(
                window,
                (GLFWvidmode.width(byteBuffer) - WIDTH) / 2,
                (GLFWvidmode.height(byteBuffer) - HEIGHT) / 2
        );

        /* Make the OpenGL context current */
        glfwMakeContextCurrent(window);

        /* Enable V-Sync */
        glfwSwapInterval(1);

        /* Show the window */
        glfwShowWindow(window);
    }

    private void renderWindow() {
        /* Required for LWJGL to work with OpenGL */
        GLContext.createFromCurrent();

        /* Set the clear color */
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

        while (glfwWindowShouldClose(window) == GL_FALSE) {
            /* Clear the frame buffer */
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            /* Swap color buffers */
            glfwSwapBuffers(window);

            /* Poll window events */
            glfwPollEvents();
        }
    }
}
