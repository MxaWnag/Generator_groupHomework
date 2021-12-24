package org.generator;
import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Iterator;
    import java.util.LinkedList;
    import java.util.NoSuchElementException;
    import java.util.Queue;
    import java.util.Random;
    public class RandomQueue<E> implements Queue<E> {

        static int length = 8;


        LinkedList<E>[][] randomlist = new LinkedList[length][length];
        Random rand;
        int count = 0;

        @Override
        public int size() {
            return count;
        }
        public RandomQueue() {
            rand = new Random(System.currentTimeMillis());
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j] = new LinkedList<E>();
                }
            }
        }
        @Override
        public boolean isEmpty() {
            return count > 0 ? false : true;
        }

        @Override
        public boolean contains(Object o) {
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    if (randomlist[i][j].contains(o)) {
                        return true;
                    }
                }
            }
            return false;
        }
        @Override
        public Iterator<E> iterator() {
            ArrayList<E> list = new ArrayList<E>();
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].toArray();
                    list.addAll(randomlist[i][j]);
                }
            }
            return list.iterator();
        }
        @Override
        public Object[] toArray() {
            ArrayList<E> list = new ArrayList<E>();
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].toArray();
                    list.addAll(randomlist[i][j]);
                }
            }
            return list.toArray();
        }
        @Override
        public <T> T[] toArray(T[] a) {
            ArrayList<E> list = new ArrayList<E>();
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].toArray();
                    list.addAll(randomlist[i][j]);
                }
            }
            return list.toArray(a);
        }
        @Override
        public boolean remove(Object o) {
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    if (randomlist[i][j].contains(o)) {
                        return randomlist[i][j].remove(o);
                    }
                }
            }
            return false;
        }
        @Override
        public boolean containsAll(Collection<?> c) {
            ArrayList<E> list = new ArrayList<E>();
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].toArray();
                    list.addAll(randomlist[i][j]);
                }
            }
            return list.containsAll(c);
        }
        @Override
        public boolean addAll(Collection<? extends E> c) {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            return randomlist[i][j].addAll(c);
        }
        @Override
        public boolean removeAll(Collection<?> c) {
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].removeAll(c);
                }
            }
            return true;
        }
        @Override
        public boolean retainAll(Collection<?> c) {
            for (int i = 0; i < length; ++i) {
                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].retainAll(c);
                }

           }
            return true;
        }
        @Override
        public void clear() {
            for (int i = 0; i < length; ++i) {

                for (int j = 0; j < length; ++j) {
                    randomlist[i][j].clear();
                }
            }
        }
        //add方法，在不违背队列的容量限制的情况，往队列中添加一个元素， 如果添加成功则返回true,  如果因为容量
        //     限制添加失败了，则抛出IllegalStateException异常
        @Override
        public boolean add(E e) {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            count++;
            return randomlist[i][j].add(e);
        }

        @Override
        public boolean offer(E e) {
            return add(e);
        }
        @Override
        public E remove() {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            for (int k = i; k < length; ++k) {
                for (int l = j; l < length; ++l) {
                    if (randomlist[k][l].isEmpty()) {
                        continue;
                    }
                    return randomlist[k][l].remove();
                }
            }
            for (int k = 0; k < i; ++k) {
                for (int l = 0; l < j; ++l) {
                    if (randomlist[k][l].isEmpty()) {
                        continue;
                    }
                    return randomlist[k][l].remove();
                }
            }
            throw new NoSuchElementException();
        }
        @Override
        public E poll() {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            try {
                for (int k = i; k < length; ++k) {
                    for (int l = j; l < length; ++l) {
                        if (randomlist[k][l].isEmpty()) {
                            continue;
                        }
                        return randomlist[k][l].remove();
                    }
                }
                for (int k = 0; k < i; ++k) {
                    for (int l = 0; l < j; ++l) {
                        if (randomlist[k][l].isEmpty()) {
                            continue;
                        }
                        return randomlist[k][l].remove();
                    }
                }
            } catch (NoSuchElementException e) {
                return null;
            }
            return null;
        }
        //返回队列头部的元素，不删除
        @Override
        public E element() {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            for (int k = i; k < length; ++k) {
                for (int l = j; l < length; ++l) {
                    if (randomlist[k][l].isEmpty()) {
                        continue;
                    }
                    return randomlist[k][l].getFirst();
                }

            }
            for (int k = 0; k < i; ++k) {
                for (int l = 0; l < j; ++l) {
                    if (randomlist[k][l].isEmpty()) {
                        continue;
                    }
                    return randomlist[k][l].getFirst();
                }       
            }
            throw new NoSuchElementException();
        }
        @Override
        public E peek() {
            int i = rand.nextInt(length);
            int j = rand.nextInt(length);
            try {
                for (int k = i; k < length; ++k) {
                    for (int l = j; l < length; ++l) {
                        if (randomlist[k][l].isEmpty()) {
                            continue;
                        }
                        return randomlist[k][l].getFirst();
                    }

                }
                for (int k = 0; k < i; ++k) {

                    for (int l = 0; l < j; ++l) {
                        if (randomlist[k][l].isEmpty()) {
                            continue;
                        }
                        return randomlist[k][l].getFirst();
                    }
                }
            } catch (NoSuchElementException e) {
                return null;
            }
            return null;
        }


    }






