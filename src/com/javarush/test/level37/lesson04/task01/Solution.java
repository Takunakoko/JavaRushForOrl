package com.javarush.test.level37.lesson04.task01;

import java.util.ArrayList;
import java.util.Iterator;

/* Круговой итератор
Класс Solution наследуется от ArrayList.
Напишите свой класс RoundIterator внутри Solution, который будет итератором для списка Solution.
Итератор должен ходить по кругу по всем элементам.
В остальном поведение должно быть идентичным текущему итератору.
*/
public class Solution<T> extends ArrayList<T>
{

    public static void main(String[] args)
    {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list)
        {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10)
            {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T>
    {
        @Override
        public void remove()
        {
            try
            {
                Solution.this.remove(index);
            }
            catch (IndexOutOfBoundsException e)
            {
                throw new IndexOutOfBoundsException();
            }
        }

        private int index = 0;

        public Iterator iterator()
        {
            return new RoundIterator();
        }

        @Override
        public boolean hasNext()
        {
            return index <= Solution.this.size();
        }

        @Override
        public T next()
        {
            if (index == Solution.this.size())
                index = 0;
            return Solution.this.get(index++);
        }
    }
}
