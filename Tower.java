import java.util.Stack;


public class Tower {
	public Stack<Integer> stack;
	public int index;
	
	public Tower(int index){
		this.index = index;
	}
	
	public int pop(){
		return this.stack.pop();
	}
	
	public void push(int item){
		this.stack.push(item);
	}
	
	public void moveDisks(Tower destination, Tower buffer, int disks ){
		if(disks >0){
			this.moveDisks(buffer, destination, disks-1);
			destination.push(this.pop());
			buffer.moveDisks(destination, this , disks-1);
		}
	}
}
