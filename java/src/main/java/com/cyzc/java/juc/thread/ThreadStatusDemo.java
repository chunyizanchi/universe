package com.cyzc.java.juc.thread;

/**
 * <ul>
 * <li>{@link Thread#getState()}<br>
 *     A thread that has not yet started is in this state.
 *     </li>
 * <li>{@link State#RUNNABLE}<br>
 *     A thread executing in the Java virtual machine is in this state.
 *     </li>
 * <li>{@link #BLOCKED}<br>
 *     A thread that is blocked waiting for a monitor lock
 *     is in this state.
 *     </li>
 * <li>{@link #WAITING}<br>
 *     A thread that is waiting indefinitely for another thread to
 *     perform a particular action is in this state.
 *     </li>
 * <li>{@link #TIMED_WAITING}<br>
 *     A thread that is waiting for another thread to perform an action
 *     for up to a specified waiting time is in this state.
 *     </li>
 * <li>{@link #TERMINATED}<br>
 *     A thread that has exited is in this state.
 *     </li>
 * </ul>
 * @author Cyzc
 * @since [2021/12/09 07:33]
 */
public class ThreadStatusDemo {



}
