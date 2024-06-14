public class Array1 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4};
        int lim=arr.length;
        int[] arr2=new int[lim];

        for (int i=0;i<lim;i++){
            System.out.println("element i ="+arr[i]);
        }
        for (int i=0;i<lim;i++){
           arr[i]=arr[2];
        }
        System.out.println(" ");
        for (int i=0;i<lim;i++){
            System.out.println("element i ="+ arr2[i]);
        }
    }
}
