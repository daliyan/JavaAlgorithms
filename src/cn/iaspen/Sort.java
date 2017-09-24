package cn.iaspen;

/**
 *  排序算法
 * @author zhiwu_yan
 *
 */
public class Sort {

	
	/**
	 * <pre>
	 * 选择排序：复杂度=N^2/2
	 *   1.找到列表中最小的元素
	 *   2.将它和第一个元素交换
	 *   3.在未排序的元素中循环1 2 步骤
	 * </pre>
	 * @param datas
	 */
	public static void selectSort(int[] datas){
		if(!checkList(datas)) {
			return;
		}
		int count = 0;
        int size = datas.length;
        for(int i = 0; i< size ; i++){
            int min = i;
            for (int j = i+1; j< size; j++){
            	count++;
                if(datas[j] < datas[min]){
                    min = j;
                }
            }
            exch(datas,i,min);
        }
        System.out.println("selectSort次数:"+count);
    }
	

	/**
	 * <pre>
	 * 插入排序
	 * 算法复杂度：N^2/4 比选择排序大概快一倍（跟输入有关系，统计结果）
	 * 和选择排序的区别在于是否利用前面已经排好的续，避免二次循环排序
	 *   模拟斗地主的理排，从左至右不断整理,改进方式：内循环较大数据向右移动，而非直接交换
	 * </pre>
	 * @param datas
	 */
	public static void insertSort(int[] datas) {
		if(!checkList(datas)) {
			return;
		}
		int count = 0;
		int size = datas.length;
		for(int i=1;i<size;i++) {
			for(int j = i;j>0;j--) {
				if(datas[j] < datas[j-1]) {
					count++;
					exch(datas,j,j-1);
				}
			}
		}
		System.out.println("insertSort次数:"+count);
	}
	

	public static boolean checkList(int[] datas) {
		if(datas == null || datas.length == 0){
            return false;
        }
		return true;
	}
	
    private static int min(int[] datas){
        int min = datas[0];
        for (int i = 0; i< datas.length; i++){
            if(datas[i] < min){
                min = datas[i];
            }
        }
        return min;
    }

    /**
     * 对 i和j index数据进行交换
     * @param a
     * @param i
     * @param j
     */
    private static void exch(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    
    public static void main(String[] args) {
    	  int[] selctSorts = new int[]{1,-2,5,4,3,-10,5};
          selectSort(selctSorts);
          for(int i =0 ;i<selctSorts.length;i++){
              System.out.println(selctSorts[i]);
          }
          
          int[] insertSorts = new int[]{-10,-2,3,5,1,4,5};
          insertSort(insertSorts);
          for(int i =0 ;i<insertSorts.length;i++){
              System.out.println(insertSorts[i]);
          }
	}

}
