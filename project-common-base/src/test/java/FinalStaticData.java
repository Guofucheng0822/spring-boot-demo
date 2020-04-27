import java.util.Random;

/**
 * static:被static修饰后，类加载时候只会加载一次
 * final:被final修饰后，一旦实例化对象，将不能被改变
 * static final：
 */
public class FinalStaticData {
    private static Random rand = new Random();//实例化一个Random对象
    //随机产生0——10的随机数赋予定义为final的a1
    private final int a1 = rand.nextInt(10);
    //随机产生0——10的随机数赋予定义为final的a2
    private static final int a2 = rand.nextInt(10);
    public static void main(String[] args){
        FinalStaticData fdata = new FinalStaticData();//实例化一个对象
        //调用定义为final的a1
        System.out.println("实例化对象调用a1的值："+fdata.a1);
        System.out.println("实例化对象调用a1的值："+fdata.a1);
        //调用定义为static final的a2
        System.out.println("实例化对象调用a2的值："+fdata.a2);
        System.out.println("实例化对象调用a2的值："+fdata.a2);
        //实例化另外一个对象
        System.out.println("-------------------------实例化另外一个对象--------------------------------");
        FinalStaticData fdata2 = new FinalStaticData();
        System.out.println("重新实例化对象调用a1的值："+fdata2.a1);
        System.out.println("重新实例化对象调用a1的值："+fdata2.a1);
        System.out.println("重新实例化对象调用a2的值："+fdata2.a2);
        System.out.println("重新实例化对象调用a2的值："+fdata2.a2);
    }
}
