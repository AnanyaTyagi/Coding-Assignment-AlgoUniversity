package BinarySearchOverAnswer;
import java.util.*;


public class Corona{

    public static boolean isCondition(int[] arr,int M,int N,int mid){
        int people_p=0;
        int startindx=0;
        int lastindx=Integer.MIN_VALUE;
        for(int i=0;i<2*M-1;i+=2){
            startindx=Math.max(lastindx+mid,arr[i]);
            if(startindx<=arr[i+1]){
                int people=((arr[i+1]-startindx)/mid)+1;
                people_p+=people;

                lastindx=startindx+(people-1)*mid;
            }
        }

        if(people_p>=N){
            return true;
        }


        return false;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();

        int[] arr=new int[2*M];

        for(int i=0;i<2*M;i+=2){
            int L=sc.nextInt();
            int R=sc.nextInt();

            arr[i]=L;
            arr[i+1]=R;
        }


        Arrays.sort(arr);




        int start=0;
        int end=arr[2*M-1];
        int mid=0;
        int res=-1;
        while(start<=end){
            mid=start+(end-start)/2;
            if(isCondition(arr,M,N,mid)==true){
                res=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }

        System.out.print(res);
    }
}
//public class Corona {
//
//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int array[] = new int[2*M +1];
//
//        for(int i = 1; i<=M; ){
//            array[i] = scanner.nextInt();
//            array[i+1] = scanner.nextInt();
//            i=i+2;
//        }
//
//        Arrays.sort(array);
//        int l = 0;
//        int r = array[2*M - 1];
//
//        while(l+1<r){
//            int mid = l + ((r-l)/2);
//            if(predicate(array,M, mid)==0){
//                l = mid;
//            } else{
//                r = mid;
//            }
//        }
//        System.out.println(l);
//    }
//
//    private static int predicate(int[] array, int m, int mid) {
//
//        int people = 1;
//        int i = 1;
//        int lastIndex = 0;
//        int distance = mid;
//
//        while(i<=m){
//            int begin = Math.max(array[i], lastIndex + distance );
//            if(begin <= array[i+1]) {
//                int islandDistance = array[i] - begin;
//                int current_people = islandDistance/distance + 1;
//                people+=current_people;
//                lastIndex = begin + ((people -1) * distance);
//            }
//          i=i+2;
//        }
//        if(people >= m)
//            return 0;
//        return 1;
//    }
//
//}
