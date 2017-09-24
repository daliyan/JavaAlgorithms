package cn.iaspen;

/**
 *  �����㷨
 * @author zhiwu_yan
 *
 */
public class Sort {

	
	/**
	 * <pre>
	 * ѡ�����򣺸��Ӷ�=N^2/2
	 *   1.�ҵ��б�����С��Ԫ��
	 *   2.�����͵�һ��Ԫ�ؽ���
	 *   3.��δ�����Ԫ����ѭ��1 2 ����
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
        System.out.println("selectSort����:"+count);
    }
	

	/**
	 * <pre>
	 * ��������
	 * �㷨���Ӷȣ�N^2/4 ��ѡ�������ſ�һ�����������й�ϵ��ͳ�ƽ����
	 * ��ѡ����������������Ƿ�����ǰ���Ѿ��źõ������������ѭ������
	 *   ģ�⶷���������ţ��������Ҳ�������,�Ľ���ʽ����ѭ���ϴ����������ƶ�������ֱ�ӽ���
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
		System.out.println("insertSort����:"+count);
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
     * �� i��j index���ݽ��н���
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
