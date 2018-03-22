package cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import dao.Food;
/**
 * ��������CJ1.C  VER 3.0��2017-12-10 
 * ��  �ܣ� ���ﳵʵ���࣬�ṩ˽�б����͸��Ե�get,set����,���췽���Լ��ӹ��ﳵ��ӡ�ɾ����Ʒ�ͼ����ܽ��� 
 * ��ȫ�ȼ���2 �� 
 * ����ˣ��±���1789194307@qq.com 
 * �����ˣ��±���1789194307@qq.com
*/
public class Cart {	
	private HashMap<Food,Integer> foods;//������Ʒ�ļ���		
	private int totalPrice;//���ﳵ���ܽ��
	public Cart()
	{
		foods = new HashMap<Food,Integer>();//ʵ����
		totalPrice = 0;//��ʼ��
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
		if(foods.containsKey(item))//�ж��Ƿ�keyֵ�Ѵ���
		{
			foods.put(item, foods.get(item)+number);//keyֵ���䣬�����ۼ�
		}
		else
		{
			foods.put(item, number);	
		}
		CartTotalPrice(); //���¼��㹺�ﳵ���ܽ��
		return true;
	}
	public boolean RemoveFoodsFromCart(Food item)
	{
		foods.remove(item);
		CartTotalPrice(); //���¼��㹺�ﳵ���ܽ��
		return true;
	}
	public int CartTotalPrice()
	{
		int sum = 0;
		Set<Food> keys = foods.keySet(); //��ü��ļ���
		Iterator<Food> it = keys.iterator(); //��õ���������
	    while(it.hasNext())
	    {
	    	Food i = it.next();
	    	sum += i.getF_price()* foods.get(i);
	    }
	    this.setTotalPrice(sum); //���ù��ﳵ���ܽ��
	    return this.getTotalPrice();
	}
}
