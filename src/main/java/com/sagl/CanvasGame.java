
package com.sagl;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.sagl.graphics.Texture;
import com.sagl.input.Input;

public abstract class CanvasGame extends Canvas implements Runnable {

    /**
     * 
     */
    private static final long serialVersionUID = -739653089776823848L;

    public static String TITLE;
    public static int WIDTH;
    public static int HEIGHT;
    public static int UPS = 20;
    public static int FPS_CAP = 60;
    protected static boolean FRAME_COUNTER = true;
    public int FPS;

    // 1,000,000,000 nano seconds in a second
    public static final long NANO_TIME = 1000000000L;

    protected static int BUFFERS = 2;

    protected boolean running;

    protected Input input;

    protected Texture img;
    protected int[] pixels;

    public CanvasGame() {

	input = new Input();

	init();

	img = new Texture(WIDTH, HEIGHT);
	pixels = img.getPixels();

	addKeyListener(input);
	addMouseListener(input);
	addMouseMotionListener(input);

	Dimension size = new Dimension(WIDTH, HEIGHT);
	setMinimumSize(size);
	setMaximumSize(size);
	setPreferredSize(size);

    }

    // Start method, you must run this in the main method
    public void start() {

	if (running)
	    return;

	Thread thread = new Thread(this);
	thread.start();
	running = true;

    }

    // Stop method
    public abstract void stop();

    // Initialization code
    public abstract void init();

    // Input method
    public abstract void input();

    // Update method
    public abstract void update();

    // Render method, draw's to the "img" object
    public abstract void render();

    // Draw method
    public void draw() {

	// Buffer strategy, useful to stop flickering of screen
	BufferStrategy bs = getBufferStrategy();

	if (bs == null) {

	    createBufferStrategy(BUFFERS);
	    return;

	}

	Graphics g = bs.getDrawGraphics();

	g.drawImage(img, 0, 0, WIDTH, HEIGHT, null);

	g.dispose();

	bs.show();

    }

    // Run method
    public void run() {

	// GAME LOOP VARIABLES

	// Current time
	long now = System.nanoTime();

	// Last time it went through the loop
	long lastTime = now;

	// How much time has passed and needs to be processed
	long unprocessedTime = 0L;

	// How much time each update takes from "unprocessedTime"
	long updateTime = NANO_TIME / UPS;

	// Timer for FPS counter
	long timer = 0L;

	// Frame counter for FPS counter
	int frameCounter = 0;

	// Whether to draw or not; saves processing power
	boolean draw = false;

	// Game loop
	while (running) {

	    now = System.nanoTime();
	    unprocessedTime = now - lastTime;
	    draw = unprocessedTime > 0L;
	    timer += unprocessedTime;

	    // FPS Counter
	    if (timer > NANO_TIME) {

		if (FRAME_COUNTER) {
		    System.out.println("FPS: " + frameCounter);
		}
		FPS = frameCounter;
		frameCounter = 0;
		timer = 0L;

	    }

	    // Update loop
	    while (unprocessedTime > 0L) {

		unprocessedTime -= updateTime;
		input();
		update();

	    }

	    // lastTime = now;
	    lastTime = System.nanoTime();

	    if (draw) {

		frameCounter++;
		render();
		draw();

	    }

	    // TODO: Frame cap

	}

    }
}
