

public class Main {
    public static int numTrucks(List<List<Integer>> inOut, int time){
        Collections.sort(inOut, new Comparator<List<Integer>>(){
            public int compare(List<Integer> a, List<Integer> b){
                return a.get(0)-b.get(0);
            }});
        PriorityQueue<Integer> queue =new PriorityQueue<Integer>(inOut.size(),
                new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b;
            }});
        int max = inOut.get(0).get(1);
        int attime=0;
        queue.add(inOut.get(0).get(1));
        for(int i=1;i<inOut.size();i++){
            if(inOut.get(i).get(0)>=queue.peek()){
                queue.poll();
            }
            queue.add(inOut.get(i).get(1));
            max = max>inOut.get(i).get(1)? max :inOut.get(i).get(1);
            if(time<inOut.get(i).get(0)){
                attime=queue.size();
            }
        }
        int size=queue.size();
        if(time<inOut.get(0).get(0) || time > max)
            return size;
        else if(time>=inOut.get(inOut.size()-1).get(0) ){
            int returned=0;
            while(queue.peek()<=time){
                returned++;
                queue.poll();
            }
            return returned;
        }
        return size-attime;
        
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> dummy1= new ArrayList<Integer>();
        dummy1.add(3);
        dummy1.add(9);
        list.add(dummy1);
        List<Integer> dummy2= new ArrayList<Integer>();
        dummy2.add(4);
        dummy2.add(10);
        list.add(dummy2);
        List<Integer> dummy3= new ArrayList<Integer>();
        dummy3.add(5);
        dummy3.add(11);
        list.add(dummy3);
        System.out.println(numTrucks(list,9));
        
    }
}
