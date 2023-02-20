package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ShowMeBug {
    static class SnapshotMap{
        private Map<String,String> latest=new HashMap<String,String>();

        private Map<Integer,Map<String,String>> snapshot=new HashMap<>();
        private int snapId=0;


        public int takeSnapshot(){
            Map<String,String> m = new HashMap<String,String>();
            int curSnapid=++snapId;
            snapshot.put(curSnapid,m);
            return curSnapid;
        }

        public void put(String key, String value){
            if(latest.containsKey(key)){
                String last=latest.get(key);
                if(snapshot.containsKey(snapId)){
                    snapshot.get(snapId).put(key,last);
                }
                latest.put(key,value);
            }else{
                latest.put(key,value);
            }
        }

        public String get(String key){
            return latest.get(key);
        }

        public void delete(String key){
            latest.remove(key);
        }

        public String get(String key,int snapId){
            if(!snapshot.containsKey(snapId)){
                return null;
            }

            return snapshot.get(snapId).getOrDefault(key,null);
        }
    }

    public static void main(String[] args) {

        SnapshotMap sm=new SnapshotMap();

        sm.put("a","123");
        sm.put("a","789");
        sm.delete("a");

        int snapId=sm.takeSnapshot();

        sm.put("a","456");

        String ans=sm.get("a");

        System.out.println(ans);

    }
}
