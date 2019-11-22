package com.cyj.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cyj.springboot.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Integer>, JpaSpecificationExecutor<Cat> {

	// ----------------------------
	// 只要继承了JpaRepository,就获得了所有的增删改查技能.你见或者不见,基本增删改查都在这里
	// ---------------------------

	// 示例内容在 com.cyj.springboot.ServiceImpl.CatServiceImpl
	// ----------------------------以上是JpaRepository已经实现好的基本增删改查------------------

	// ----------------------------以下是自定义条件查询--------------------------------------

	// Cat实体的属性: id, name, sex, age, birthday, updateTime,catParam

	// And --- 等价于 SQL 中的 and 关键字，比如 findByAgeAndSex(int Age,char sex)；
	public List<Cat> findByNameAndSex(String name, String sex);

	// Or --- 等价于 SQL 中的 or 关键字，比如 findByAgeOrSex(int Age,char sex)；
	public List<Cat> findByNameOrSex(String name, String sex);

	// Between --- 等价于 SQL 中的 between 关键字，比如 findByAgeBetween(int min, int max)；
	public List<Cat> findByAgeBetween(int min, int max);

	// LessThan --- 等价于 SQL 中的 "<"，比如 findByAgeLessThan(int max)；
	public List<Cat> findByAgeLessThan(int max);

	// GreaterThan --- 等价于 SQL 中的">"，比如 findByAgeGreaterThan(int min)；
	public List<Cat> findByAgeGreaterThan(int min);

	// IsNull --- 等价于 SQL 中的 "is null"，比如 findByNameIsNull()；
	public List<Cat> findByNameIsNull();

	// IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByNameIsNotNull()；
	public List<Cat> findByNameIsNotNull();

	// NotNull --- 与 IsNotNull 等价；
	public List<Cat> findByNameNotNull();

	// Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);
	public List<Cat> findByNameLike(String name);

	// NotLike --- 等价于 SQL 中的 "not like"，比如 findByNameNotLike(String name)；
	public List<Cat> findByNameNotLike(String name);

	// OrderBy --- 等价于 SQL 中的 "OrderBy"，比如 findByNameNotNullCatByAgeAsc()；
	public List<Cat> findByNameNotNullOrderByAgeAsc();

	// Not --- 等价于 SQL 中的 "！ ="，比如 findByNameNot(String name)；
	public List<Cat> findByNameNot(String name);

	// In --- 等价于 SQL 中的 "in"，比如 findByNameIN(String name);
	public List<Cat> findByNameIn(String name);

	// NotIn --- 等价于 SQL 中的 "not in"，比如 findByNameNotIN(String name);
	public List<Cat> findByNameNotIn(String name);

	// And --- 等价于 SQL 中的 and 关键字，比如 findByAgeAndSex(int Age,char sex)；
	public List<Cat> findByAgeAndSex(int Age, char sex);

	// Or --- 等价于 SQL 中的 or 关键字，比如 findByAgeOrSex(int Age,char sex)；
	public List<Cat> findByAgeOrSex(int Age, char sex);

	// StartingWith findByNameStartingWith ... where x.name like ?1(parameter bound
	// with appended %)
	public List<Cat> findByNameStartingWith(String name);

	// EndingWith findByNameEndingWith ... where x.name like ?1(parameter bound with
	// prepended %)
	public List<Cat> findByNameEndingWith(String name);

	// Containing findByNameContaining ... where x.name like ?1(parameter bound
	// wrapped in %)
	public List<Cat> findByNameContaining(String name);

	// OrderBy findByAgeOrderByName ... where x.age = ?1 order by x.name desc
	public List<Cat> findByNameOrderByAge(String name, Integer age);
	// True findByActiveTrue ... where x.avtive = true
	// public List<Cat> findByActiveTrue();
	// Flase findByActiveFalse ... where x.active = false
	// public List<Cat> findByActiveFalse();

	// Like --- 等价于 SQL 中的 "like"，比如 findByNameLike(String name);
	public List<Cat> findByNameLike(String name, Sort sort);

	public Page<Cat> findByNameLike(String name, Pageable pageable);

	// ******************** []HQL 方式 ] 序号参数*******************

	// Cat实体的属性: id, name, sex, age, birthday, updateTime

	// 以HQL方式获取数据

	// 前面介绍的获取数据的方式都没有使用到任何的HQL语句，那些方法已经可以满足很多需求，也有时候会觉得方法名太长不太方便，下面介绍一下使用Hql方式获取数据：

	// 在ICatService中加入 ：

	@Query("FROM Cat c WHERE c.name=?1 AND c.sex IS NOT NULL")
	List<Cat> findAll(String name);

	/*
	 * 测试方法
	 * 
	 * @Test public void testQuery() { List<Cat> list = CatService.findAll("Cat3");
	 * System.out.println(list.size()); }
	 */

	// 修改数据

	// 在ICatService接口中写一个修改的方法，只要涉及修改或删除数据的操作都需要加上注释@Modifying和@Transcational（Transcational是org.springframework.transaction.annotation包中的不要导错了）

	@Query("UPDATE Cat c SET c.age=?2 WHERE c.id=?1")
	@Modifying
	@Transactional
	void updatePwd(Integer id, Integer age);

	/*
	 * 测试方法
	 * 
	 * @Test public void testUpdate() { CatService.updatePwd(1, 100); }
	 */

	// 删除数据

	// 在ICatService接口中的方法：

	@Query("DELETE FROM Cat c WHERE c.name=?1")
	@Modifying
	@Transactional
	void deleteByCatName(String name);

	/*
	 * 测试方法
	 * 
	 * @Test public void testDelete() { CatService.deleteByCatName("Cat4"); }
	 */

	// 在上面的操作方式中参数传递都是以一种有序的方式传递的，另外还有一种更为直观的[命名参数]方式来传递参数，下面举个例子说明：
	// ******************** []HQL 方式 ] 序号参数*******************
	// 注意： 在参数传中参数前加注释@Param并指定名称，在@Query中使用:名称的方式来传递参数。

	// 在接口ICatService中添加方法：

	@Query("UPDATE Cat c SET c.sex= :sex WHERE c.id = :id")
	@Modifying
	@Transactional
	void updateEmail(@Param("id") Integer id, @Param("sex") String sex);

	/*
	 * 测试方法
	 * 
	 * @Test public void testUpdate2() { CatService.updateCat(1, "女"); }
	 */
	@Query(" SELECT MAX(c.age) FROM Cat c ")
	public Long maxAge();

	@Query("select c from Cat c where  c.name like %:name% ")
	List<Cat> queryByname(@Param(value = "name") String name);

	// **************************一些复杂查询[原生的SQl]***********************
	// 一些比较复杂的关联查询要怎么实现呢，JPA的处理方法是：利用[原生的SQl]命令来实现那些复杂的关联查询，下面就来看下案例。

	// 通过设置 nativeQuery = true 来设置开启使用数据库原生SQL语句

	// 利用原生的SQL进行查询操作
	@Query(value = "select c.* from ordertb o ,cattb u where o.uid=u.id and u.name=?1", nativeQuery = true)
	@Modifying
	public List<Cat> findCatByName(String name);

	// 利用原生的SQL进行删除操作
	@Query(value = "delete from cattb where id=?1 ", nativeQuery = true)
	@Modifying
	public void deleteCatById(int id);

	// 利用原生的SQL进行删除操作
	@Query(value = "delete from cattb where uid=?1 ", nativeQuery = true)
	@Modifying
	public void deleteCatByUId(int uid);

	// 利用原生的SQL进行修改操作
	@Query(value = "update cattb set name=?1 where id=?2 ", nativeQuery = true)
	@Modifying
	public void updateCatName(String name, int id);

	// 利用原生的SQL进行插入操作
	@Query(value = "insert into cattb(name,uid) value(?1,?2)", nativeQuery = true)
	@Modifying
	public void insertCat(String name, int uid);

	@Query(value = " SELECT * FROM cattb WHERE NAME LIKE %:name% ", nativeQuery = true)
	List<Cat> queryBynameSQL(@Param(value = "name") String name);

	// *******************JPA分页*******************************
	// JPA是怎么实现分页的效果，其实JPA脱胎于hibernate，所以本身就对分页功能有很好的支持。

	// 实现分页功能
	Page<Cat> findByNameNot(String name, Pageable pageable);

	// @RequestMapping(value = "/params")
	// @ResponseBody
	/*
	 * public String getEntryByParams(String name, Integer page,Integer size) { Sort
	 * sort = new Sort(Sort.Direction.DESC, "id"); Pageable pageable = new
	 * PageRequest(page, size, sort); Page<Cat>
	 * pages=CatDao.findByNameNot(name,pageable); Iterator<Cat> it=pages.iterator();
	 * while(it.hasNext()){ System.out.println("value:"+((Cat)it.next()).getId()); }
	 * return "success...login...."; }
	 */

	/*
	 * 上面的代码一个是在dao层中的，一个是在controller中的。
	 * 
	 * dao层中添加一个返回值为Page，参数值为Pageable。controller层中通过实例化Pageable这个类，然后调用dao层这个分页方法。
	 * 
	 * 通过这些步骤就可以轻轻松松的实现分页的效果啦，看起来是不是特别方便。
	 */

	// 最后在给大家介绍一下JPA是如何实现事务操作的。其实因为SpringBoot中已经对事务做了很好的封装了，使用起来特别方便。下面看一下案例：

	/*
	 * @RequestMapping("/saveCat")
	 * 
	 * @ResponseBody
	 * 
	 * @Transactional() public String saveCat(){ Cat o1=new Cat("11",2); Cat o2=new
	 * Cat("22",2); Cat o3=new Cat("33",2); Cat o4=new Cat("44",2); CatDao.save(o1);
	 * CatDao.save(o2); CatDao.save(o3); CatDao.save(o4); return
	 * "successfull....saveCat......"; }
	 */

	/*
	 * 只要在方法的上面加上@Transaction 这个注解就可以轻轻松松的实现事务的操作了，是不是特别方便啊。 不过这里有几点需要注意的是：
	 * 
	 * 1.这个注解实现的事务管理器是默认的，如果不想要默认是事务管理器，可以自己进行添加，我这里就不多介绍了。
	 * 
	 * 2.事务的隔离级别也是可以自己设置的。
	 * 
	 * 3.事务的传播行为也是可以自己设置的。
	 */

}
