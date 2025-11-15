12.1 – What Are Threads?

(Complete theory + example programs)

📘 12.1 – What Are Threads?
Introduction

When we run a program on a computer, it runs inside the operating system (OS).
The OS interacts with hardware components:

✔ CPU

Executes instructions, performs arithmetic & logic operations.

✔ RAM

Temporary fast-access memory.

✔ ROM

Non-volatile memory used for firmware and system boot.

Understanding Multi-tasking & Time-sharing

Modern OS supports multi-tasking → multiple programs appear to run simultaneously.

The CPU uses time slicing:

Each task gets a small CPU time slice

It quickly switches tasks

Appears concurrent even on a single-core CPU

What is a Thread?

A thread is the smallest unit of execution.

A process:

Has its own address space

Contains one or more threads

Manages memory/resources

A thread:

Shares memory with other threads in the same process

Has its own stack, program counter, registers

Executes independently

Threads are lightweight compared to processes.

Why Threads?

✔ Faster & parallel execution
✔ Better CPU usage
✔ Shared memory model
✔ Improves responsiveness
✔ Enables concurrency

Real Life Examples
Web Browser

Thread for UI

Thread for downloading

Thread for playing media

Thread for JavaScript

Games

Rendering

Physics

AI logic

Sound

💻 CODE EXAMPLE 1 — Creating a Thread
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();  // starts the thread
    }
}

💻 CODE EXAMPLE 2 — Demonstrating Time Sharing
class A extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println("A: " + i);
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println("B: " + i);
    }
}

public class Demo {
    public static void main(String[] args) {
        new A().start();
        new B().start();
    }
}

💻 CODE EXAMPLE 3 — Why We Need Threads
Without Threads
class Task1 {
    void work() {
        for(int i=1;i<=5;i++)
            System.out.println("Task 1");
    }
}
class Task2 {
    void work() {
        for(int i=1;i<=5;i++)
            System.out.println("Task 2");
    }
}
public class Demo {
    public static void main(String[] args) {
        new Task1().work();
        new Task2().work();
    }
}

With Threads
class Task1 extends Thread {
    public void run() {
        for(int i=1;i<=5;i++)
            System.out.println("Task 1");
    }
}
class Task2 extends Thread {
    public void run() {
        for(int i=1;i<=5;i++)
            System.out.println("Task 2");
    }
}
public class Demo {
    public static void main(String[] args) {
        new Task1().start();
        new Task2().start();
    }
}

💻 CODE EXAMPLE 4 — Browser Simulation
class Download extends Thread {
    public void run() {
        System.out.println("Downloading...");
    }
}
class Render extends Thread {
    public void run() {
        System.out.println("Rendering...");
    }
}
public class Browser {
    public static void main(String[] args) {
        new Download().start();
        new Render().start();
    }
}

End of Section 12.1
📘 12.2 – Multiple Threads
📘 12.2 – Multiple Threads (Theory + Code)
Sequential Execution (No Threads)
class Hi {
    public void show() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hi");
    }
}
class Hello {
    public void show() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hello");
    }
}

public class Demo {
    public static void main(String[] args) {
        Hi h = new Hi();
        Hello he = new Hello();
        h.show();
        he.show();
    }
}


Output is sequential.

Parallel Execution (Using Threads)
class Hi extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hi");
    }
}
class Hello extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("Hello");
    }
}

public class Demo {
    public static void main(String[] args) {
        new Hi().start();
        new Hello().start();
    }
}

Thread Scheduler Behavior

The scheduler decides:

Which thread runs

For how long

On which CPU core

Multicore CPUs run multiple threads simultaneously.

Advantages

✔ Faster execution
✔ Better CPU usage
✔ Non-blocking behavior

📘 12.3 – Thread Priority & Sleep
🔺 Thread Priority

Every thread in Java has a priority from 1 to 10:

MIN_PRIORITY = 1

NORM_PRIORITY = 5 (default)

MAX_PRIORITY = 10

Higher priority → Higher chance to be scheduled first
(Not guaranteed)

💻 Example: Thread Priority
class A extends Thread {
    public void run() {
        System.out.println("Thread A running");
    }
}

class B extends Thread {
    public void run() {
        System.out.println("Thread B running");
    }
}

public class Demo {
    public static void main(String[] args) {

        A t1 = new A();
        B t2 = new B();

        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.MAX_PRIORITY); // 10

        t1.start();
        t2.start();
    }
}

😴 Thread.sleep()

Thread.sleep(milliseconds) pauses the current thread.

💻 Example: Using sleep()
class A extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("A: " + i);
            try {
                Thread.sleep(1000); // 1 second
            } catch(Exception e) {}
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        new A().start();
    }
}

Combined Example (Priority + Sleep)
class Download extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Downloading chunk: " + i);
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}

class PlayMusic extends Thread {
    public void run() {
        for(int i = 1; i <= 5; i++)
            System.out.println("Playing music");
    }
}

public class Demo {
    public static void main(String[] args) {
        Download d = new Download();
        PlayMusic p = new PlayMusic();

        d.setPriority(10);
        p.setPriority(1);

        d.start();
        p.start();
    }
}

End of 12.3 – Thread Priority & Sleep
📘 12.4 – Runnable vs Thread

This topic explains two ways to create threads.

1️⃣ Extending Thread class

Subclass Thread

Override run()

Call start()

💻 Example (extends Thread)
class A extends Thread {
    public void run() {
        System.out.println("Thread A running");
    }
}

public class Demo {
    public static void main(String[] args) {
        A obj = new A();
        obj.start();
    }
}

2️⃣ Implementing Runnable Interface

A class implements Runnable

run() method contains job

Pass object to Thread class

Call start()

💻 Example (implements Runnable)
class A implements Runnable {
    public void run() {
        System.out.println("Runnable A running");
    }
}

public class Demo {
    public static void main(String[] args) {
        Thread t = new Thread(new A());
        t.start();
    }
}

Which is better? – Runnable is preferred

✔ Java supports only single inheritance
→ If you extend Thread, you cannot extend another class

✔ Runnable separates job from worker
→ Clean design

✔ Used in Executors, Thread Pools, Frameworks

💻 PDF Example: Two Runnable Tasks
class A implements Runnable {
    public void run() {
        for(int i = 1; i <= 5; i++)
            System.out.println("Inside A thread");
    }
}

class B implements Runnable {
    public void run() {
        for(int i = 1; i <= 5; i++)
            System.out.println("Inside B thread");
    }
}

public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());

        t1.start();
        t2.start();
    }
}

Comparison Table
Feature	Thread	Runnable
Inheritance	Extends Thread	Implements Runnable
Multiple inheritance	❌ Not possible	✔ Possible
Separation of job	❌ No	✔ Yes
Used in ThreadPool	❌ Rarely	✔ Always



📘 12.5 – Race Condition

A race condition happens when two or more threads try to access and modify the same shared resource at the same time.

This causes:

❌ Wrong output
❌ Unpredictable behavior
❌ Lost updates

Example of a Race Condition
Shared Resource
class Counter {
    int count = 0;

    public void increment() {
        count++;   // critical section
    }
}

Two Threads Modifying Shared Data
public class Demo {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count = " + c.count);
    }
}

❌ Expected Output
Final Count = 2000

❗ Actual Output
Final Count = 1834   (or some random number)


This is because:

Both threads read the same value

Both update independently

One thread’s update overwrites the other’s

Why Race Conditions Occur?

count++; is NOT atomic.
It performs:

Read count

Add 1

Write count

If two threads overlap → corruption happens.

✔ Fix: Use synchronized
class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}


Now, when threads run:

Only one thread enters increment() at a time

No lost updates

Consistent final result

Updated Program (Correct Version)
public class Demo {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) c.increment();
        });

        t1.start();  
        t2.start();
        t1.join();  
        t2.join();

        System.out.println("Final Count = " + c.count);
    }
}

📎 Extra Notes from PDF

Race conditions occur in shared mutable state

Common in banking, ticket bookings, counters

Use:

synchronized

locks

atomic variables

✔ End of Section 12.5 – Race Condition
📘 12.6 – Thread States

Java defines 6 thread states:

NEW → RUNNABLE → RUNNING → BLOCKED → WAITING / TIMED_WAITING → TERMINATED

1️⃣ NEW

Thread is created but start() not called.

Thread t = new Thread();
System.out.println(t.getState()); // NEW

2️⃣ RUNNABLE

After calling start(), the thread becomes runnable:

Eligible to run

Waiting for CPU

3️⃣ RUNNING

Thread is actually executing.

4️⃣ BLOCKED

Thread is waiting to enter a synchronized block/method.

5️⃣ WAITING

Thread is waiting indefinitely until:

notify()

notifyAll()

another thread releases lock

6️⃣ TIMED_WAITING

Thread is waiting for a specific time:

sleep(time)

wait(time)

join(time)

7️⃣ TERMINATED

Thread completes execution.

💻 Java Program Showing All States
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running...");
        try {
            Thread.sleep(1000); // TIMED_WAITING
        } catch (Exception e) {}
    }
}

public class ThreadStatesDemo {
    public static void main(String[] args) throws Exception {

        MyThread t = new MyThread();

        // 1. NEW
        System.out.println("State: " + t.getState());

        // 2. RUNNABLE
        t.start();
        System.out.println("State: " + t.getState());

        // 3. TIMED_WAITING
        Thread.sleep(100);
        System.out.println("State: " + t.getState());

        // 4. TERMINATED
        t.join();
        System.out.println("State: " + t.getState());
    }
}

🧠 Expected Output
State: NEW
State: RUNNABLE
State: TIMED_WAITING
State: TERMINATED

Thread State Diagram (Text)
NEW → RUNNABLE → RUNNING → (BLOCKED / WAITING / TIMED_WAITING) → TERMINATED

✔ End of Section 12.6 – Thread States
🎉 YOU NOW HAVE EVERYTHING

✔ 12.1 – What Are Threads
✔ 12.2 – Multiple Threads
✔ 12.3 – Thread Priority & Sleep
✔ 12.4 – Runnable vs Thread
✔ 12.5 – Race Condition
✔ 12.6 – Thread States