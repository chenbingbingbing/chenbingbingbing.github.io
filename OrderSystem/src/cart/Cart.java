package cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import dao.Food;
/**
 * 程序名：CJ1.C  VER 3.0，2017-12-10 
 * 功  能： 购物车实体类，提供私有变量和各自的get,set方法,构造方法以及从购物车添加、删除菜品和计算总金额方法 
 * 安全等级：2 级 
 * 编程人：陈冰；1789194307@qq.com 
 * 测试人：陈冰；1789194307@qq.com
*/
public class Cart {	
	private HashMap<Food,Integer> foods;//购买商品的集合		
	private int totalPrice;//购物车的总金额
	public Cart()
	{
		foods = new HashMap<Food,Integer>();//实例化
		totalPrice = 0;//初始化
	}
	public HashMap<Food, Integer> getFoods() {
		return foods;
	}
	public void setFoods(HashMap<Food, Integer> foods) {
		this.foods = foods;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public boolean AddFoodsInCart(Food item ,int number)
	{
		if(foods.containsKey(item))//判断是否key值已存在
		{
			foods.put(item, foods.get(item)+number);//key值不变，数量累加
		}
		else
		{
			foods.put(item, number);	
		}
		CartTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	public boolean RemoveFoodsFromCart(Food item)
	{
		foods.remove(item);
		CartTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	public int CartTotalPrice()
	{
		int sum = 0;
		Set<Food> keys = foods.keySet(); //获得键的集合
		Iterator<Food> it = keys.iterator(); //获得迭代器对象
	    while(it.hasNext())
	    {
	    	Food i = it.next();
	    	sum += i.getF_price()* foods.get(i);
	    }
	    this.setTotalPrice(sum); //设置购物车的总金额
	    return this.getTotalPrice();
	}
}
