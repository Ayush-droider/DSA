class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> nlist = new ArrayList<>();

        int i = 0, j = 0;

        // Merge both arrays
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]){
                list.add(a[i]);
                i++;
            }
            else{
                list.add(b[j]);
                j++;
            }
        }

        while(i < a.length){
            list.add(a[i]);
            i++;
        }

        while(j < b.length){
            list.add(b[j]);
            j++;
        }

        // Remove duplicates
        if(list.size() > 0)
            nlist.add(list.get(0));   // ✅ add first element

        for(int k = 1; k < list.size(); k++){
            if(!list.get(k).equals(list.get(k-1))){
                nlist.add(list.get(k));
            }
        }

        return nlist;
    }
}