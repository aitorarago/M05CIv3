package original;

/*============================================================================
Name        : LinkedList.java
Author      : Eric Swanson
Date	    : Sep 7, 2011
Version     :
Description :
Copyright (C) 2011 netherwolfe
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
============================================================================*/
//Source: https://gist.github.com/es20641/1208340/06d598126d53b048058bc243cbc4e4dd7db9a23a

class LinkedList
{
    //Class variables for the Linked List
    private Node head;
    private int numNodes;

    public LinkedList(Object dat)
    {
        head = new Node(dat);
        numNodes++;
    }

    public void addAtHead(Object dat)
    {
        Node temp = head;
        head = new Node(dat);
        head = temp;
        numNodes++;
    }

    public void addAtTail(Object dat)
    {
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node(dat);
    }

    public void addAtIndex(int index, Object dat)
    {
        Node temp = null;
        if(index <= 0){
            temp = head;
            head = new Node(dat);
            head.next = temp;
        }
        else {
            temp = getPrevious(index);
            Node holder = temp.next;
            temp.next = new Node(dat);
            temp.next.next = holder;
        }
        numNodes++;
    }

    public void deleteAtIndex(int index)
    {
        if(index <= 0) head = head.next;
        else {
            index = Math.min(index, getSize()-1);
            Node temp = getPrevious(index);
            temp.next = temp.next.next;
        }
        numNodes--;
    }

    private Node getPrevious(int index) {
        Node temp = head;
        for(int i=0; i< index - 1 && temp.next != null; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int index)
    {
        Node temp=head;
        for(int i=0; i<index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public String toString()
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public int getSize()
    {
        return numNodes;
    }

    class Node
    {
        //Declare class variables
        private Node next;
        private Object data;

        public Node(Object dat)
        {
            data = dat;
        }

        public Object getData()
        {
            return data;
        }
    }
}