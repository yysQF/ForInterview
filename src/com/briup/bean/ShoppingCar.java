package com.briup.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName: ShoppingCar 模拟购物车的对象
 *
 */
@Component
public class ShoppingCar {
	//key是book的id
	//value是订单明细
	@Autowired
	private OrderLine line;
	
	public void setLine(OrderLine line) {
		this.line = line;
	}
	private Map<Integer, OrderLine> map = new HashMap<Integer, OrderLine>();
	
	//向购物车添加书籍
	public void add(OrderLine line){
		if(map.containsKey(line.getBook().getBookId())){
			OrderLine oldline = map.get(line.getBook().getBookId());
			oldline.setNum(oldline.getNum()+line.getNum());
		}else{
			line.setNum(line.getNum());
			map.put(line.getBook().getBookId(), line);
		}
	}
	
	//删除购物车的书籍
	public void delete(int bookId){
		map.remove(bookId);
	}
	/**
	 * 计算购物车所有物品的总价
	 */
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			OrderLine value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	/**
	 * 返回map对象
	 * List<Line>
	 */
	public Map<Integer, OrderLine> getLines(){
		return map;
	}
	/**
	 * 清空购物车
	 */
	public void clear(){
		map.clear();
	}
	
	/**
	 * 更新购物车某本书籍的数量
	 */
	public void update(int key,int num){
		OrderLine line = map.get(key);
		if(line!=null){
			line.setNum(num);
		}
	}
	//购物车物品总的数量
	public int getNum(){
		int num = 0;
		for(OrderLine line:map.values()) {
			num += line.getNum();
		}
		return num;
	}
	
}