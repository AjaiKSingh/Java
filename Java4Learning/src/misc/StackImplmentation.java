package misc;

import java.util.Arrays;

public class StackImplmentation 
{
	//implement stack wo using in built stack api : LIFO
	//push : Put in
	//pop : take out
	//peek: get the reference of last input without removing it
	//initial capacity
	//full stack
	
	//data in stack are of type int
	//wont delete the data after poping up, just replace the values just in case its pushed after pop (referencing capacity)

	public static void main(String ajai[])
	{
		System.out.println("Stack Test");
		MyStack oStack = new MyStack(5); //5 capacity
		
		oStack.push(1);
		System.out.println(oStack.toString());
		oStack.push(2);
		oStack.push(3);
		oStack.push(4);
		oStack.push(5);
		System.out.println(oStack.toString());
		//oStack.push(6); //Runtime exception
		
		System.out.println(oStack.pop());
		System.out.println(oStack.pop());
		System.out.println(oStack.toString());
		
		oStack.push(6);
		System.out.println(oStack.toString());
	}
	
}
class MyStack
{
	private int array[];
	private int top;
	private int capacity;
	
	MyStack(int capacity)
	{
		this.array = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}
	private boolean isFull() {
		// TODO Auto-generated method stub
		return top==capacity-1;
	}
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==-1;
	}
	
	public void push(int item)
	{
		if(isFull())
			throw new RuntimeException("Stack is Full");
		array[++top]= item; //add to the array and increase the top index
	}
	public int pop()
	{
		if(isEmpty())
			throw new RuntimeException("Stack is Empty");
	
		return array[top--]; //return the top value and shift the top index as well
	}
	public int peek()
	{
		if(isEmpty())
			throw new RuntimeException("Stack is Empty");
		return array[top]; //return the top value
	}	
	
	public String toString()
	{
		return Arrays.toString(array);
		
	}
}