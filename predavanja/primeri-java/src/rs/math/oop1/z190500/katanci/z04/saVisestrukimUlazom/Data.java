package rs.math.oop1.z190500.katanci.z04.saVisestrukimUlazom;

/**
 * primer preuzet sa stranice:
 * http://programmingexamples.wikidot.com/reentrantreadwritelock
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data{
	
	private List<String> names;

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public Data(){
		names = new ArrayList<String>();
	}

	public List<String> getNames(){
		return names;
	}

	public void setNames(List<String> names){
		this.names = names;
	}

	public void add(String str){
		lock.writeLock().lock();
		try {
			System.out.println("Writer: Number of threads waiting : "
					+ lock.getQueueLength());

			// This will always be 1.
			System.out.println("Writer: Number of write locks waiting : "
					+ lock.getWriteHoldCount());
			names.add(str);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void readData(){
		lock.readLock().lock();
		try{
			System.out.println("Reader: Number of threads waiting : "
					+ lock.getQueueLength());
			System.out.println("Reader: Number of read locks : "
					+ lock.getReadLockCount());
			Iterator<String> iter = names.iterator();
			while (iter.hasNext()){
				//iter.next();
				System.out.println(iter.next());
			}
			try{
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}finally{
			lock.readLock().unlock();
		}
	}
}
