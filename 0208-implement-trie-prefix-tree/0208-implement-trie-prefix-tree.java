class Trie {
    class Node{
        Node[] arr=new Node[26];
        boolean flag=false;

        boolean containsKey(char ch){
            return arr[ch-'a']!=null;
        }
        void put(char ch,Node node){
            arr[ch-'a']=node;
        }
        Node get(char ch){
            return arr[ch-'a'];
        }
    }
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.flag=true;
    }
    
    public boolean search(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch))return false;
            node=node.get(ch);
        }
        if(node.flag)return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node=root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch))return false;
            node=node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */