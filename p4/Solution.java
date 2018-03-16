public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = m+n;
        if(k%2!=0){
            return foundK(nums1,0,n-1,nums2,0,m-1,k/2+1);
        }else{
            double mid1 = foundK(nums1,0,n-1,nums2,0,m-1,k/2);
            double mid2 = foundK(nums1,0,n-1,nums2,0,m-1,k/2+1);
            return (mid1+mid2)/2;
        }
    }
    private int foundK(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1>len2){
            return foundK(nums2,start2,end2,nums1,start1,end1,k);
        }
        if(len1==0){
            return nums2[start2+k-1];
        }
        if(k==1){
            return nums1[start1]<nums2[start2]?nums1[start1]:nums2[start2];
        }
        int mid1 = k/2;
        mid1 = mid1<len1?mid1:len1;
        int mid2 = k-mid1;
        int index1 = start1+mid1-1;
        int index2 = start2+mid2-1;
        if(nums1[index1]==nums2[index2]){
            return nums1[index1];
        }else if(nums1[index1]<nums2[index2]){
            return foundK(nums1,index1+1,end1,nums2,start2,index2,k-(index1-start1+1));
        }else{
            return foundK(nums1,start1,index1,nums2,index2+1,end2,k-(index2-start2+1));
        }
    }
}
