package com.cyj.springboot.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.cyj.springboot.dao.CatRepository;
import com.cyj.springboot.entity.Cat;
import com.cyj.springboot.entitysearch.CatSearch;
import com.cyj.springboot.service.CatService;



@Service
public class CatServiceImpl implements CatService{
	
	@Autowired
	private CatRepository repository;
	
	@Override
	public Cat insert(Cat cat) {
		return repository.save(cat);
	}
	@Override
	public List<Cat> insert(List<Cat> list) {
		return repository.save(list);
	}
	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	@Override
	public void delete(Cat cat) {
		repository.delete(cat);
	}
	@Override
	public void delete(List<Cat> list) {
		repository.delete(list);
	}
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	@Override
	public Cat update(Cat cat) {
		return repository.save(cat);
	}
	@Override
	public List<Cat> update(List<Cat> list){
		return repository.save(list);
	}
	@Override
	public Boolean exists(Integer id){
		return repository.exists(id);
	}
	@Override
	public Long count() {
		return repository.count();
	}
	@Override
	public Cat queryById(Integer id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<Cat> queryAll(){
		return repository.findAll();
	}
		
	@Override
	public List<Cat> queryAllSort(String fieldName){//排序
//		Sort sort = new Sort(Sort.Direction.DESC, "id"); 
//	    Pageable pageable = new PageRequest(page, size, sort);
		Sort sort = new Sort(Sort.Direction.DESC, fieldName,"id");
		return repository.findAll(sort);
	}
	@Override
	public Page<Cat> queryAllPage(Integer page,Integer size){//分页
		Sort sort = new Sort(Sort.Direction.ASC, "id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return repository.findAll(pageable);
	}
	
	
	
	
	//----------------------------以上是JpaRepository已经实现好的基本增删改查------------------
	
	
	
	@Override
	public Long queryMaxAge() {
		return repository.maxAge();
	}
	

	@Override
	public List<Cat> queryByNameLike(String name){
		return repository.findByNameLike("%"+name+"%");
	}
	
	@Override
	public List<Cat> queryByName(String name){
		return repository.queryByname(name);
	}
	
	@Override
	public List<Cat> queryByNameSQL(String name){
		return repository.queryBynameSQL(name);
	}
	

	@Override
	public List<Cat> queryNameLikeAllSort(String nameLike,String fieldName){//带条件的排序
//		Sort sort = new Sort(Sort.Direction.DESC, "id"); 
//	    Pageable pageable = new PageRequest(page, size, sort);
		Sort sort = new Sort(Sort.Direction.DESC, fieldName,"id");
		return repository.findByNameLike("%"+nameLike+"%", sort);
	}
	@Override
	public Page<Cat> queryNameLikeAllPage(String nameLike,Integer page,Integer size){//带条件的分页
		Sort sort = new Sort(Sort.Direction.ASC, "id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return repository.findByNameLike("%"+nameLike+"%", pageable);
	}
	
	
	
	
	
	
	//----------------------------使用JpaRepository,Specification动态SQL查询------------------
	
	
	@Override
	public List<Cat> queryByDynamicSQL(CatSearch catSearch){
		return repository.findAll(this.getWhereClause(catSearch));
	}
	@Override
	public List<Cat> queryByDynamicSQL02(CatSearch catSearch){
		return repository.findAll(this.getWhereClause02(catSearch));
	}
	
	@Override
	public Page<Cat> queryByDynamicSQLPage(CatSearch catSearch,Integer page,Integer size){//动态查询条件的排序分页
		Sort sort = new Sort(Sort.Direction.ASC, "id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
		return repository.findAll(this.getWhereClause(catSearch),pageable);
	}
	
	
	//Cat实体的属性:  id, name, sex, age, birthday, updateTime
	
	
	
	//Cat实体的属性:  id, name, sex, age, birthday, updateTime
	//CatSearch实体的属性:  name, sex, minAge, maxAge, startBirthday, endBirthday, startUpdateTime, endUpdateTime
	
	
	
	/**
	  * 查询条件动态组装
	  * 动态生成where语句
	  * 匿名内部类形式
	  * @param catSearch
	  * @return
	  */
   private Specification<Cat> getWhereClause(final CatSearch catSearch){
       return new Specification<Cat>() {
			@Override
			public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();//动态SQL表达式			
				List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合
				
				
				
               if( catSearch.getName() != null && !"".equals(catSearch.getName()) ){
            	   exList.add(cb.like(root.<String>get("name"), "%"+catSearch.getName()+"%"));
               }
               if( catSearch.getSex() != null && !"".equals(catSearch.getSex()) ){
            	   exList.add(cb.equal(root.get("sex").as(String.class), catSearch.getSex()));
               }
               if( catSearch.getMinAge() != null ){
            	   exList.add(cb.greaterThanOrEqualTo(root.<Integer>get("age"), catSearch.getMinAge()));
               }
               if( catSearch.getMaxAge() != null ){
            	   exList.add(cb.lessThanOrEqualTo(root.get("age").as(Integer.class), catSearch.getMaxAge()));
               }
               if( catSearch.getStartBirthday() != null ){
            	   exList.add(cb.greaterThanOrEqualTo(root.<Date>get("birthday"), catSearch.getStartBirthday()));//大于等于起始日期
               }
               if( catSearch.getEndBirthday() != null ){
            	   exList.add(cb.lessThanOrEqualTo(root.get("birthday").as(Date.class), catSearch.getEndBirthday()));//小于等于截止日期
               }
               
               
               
               return predicate;
			}

       };
   }
	
	 /**
	  * 查询条件动态组装
	  * 动态生成where语句
	  * 匿名内部类形式
	  * @param catSearch
	  * @return
	  */
    private Specification<Cat> getWhereClause02(final CatSearch catSearch){
        return new Specification<Cat>() {
			@Override
			public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> pList = new ArrayList<Predicate>();
                if( catSearch.getName() != null && !"".equals(catSearch.getName()) ){
                	pList.add(cb.like(root.<String>get("name"), "%"+catSearch.getName()+"%"));
                }
                if( catSearch.getSex() != null && !"".equals(catSearch.getSex()) ){
                	pList.add(cb.equal(root.get("sex").as(String.class), catSearch.getSex()));
                }
                if( catSearch.getMinAge() != null ){
                	pList.add(cb.greaterThanOrEqualTo(root.<Integer>get("age"), catSearch.getMinAge()));
                }
                if( catSearch.getMaxAge() != null ){
                	pList.add(cb.lessThanOrEqualTo(root.get("age").as(Integer.class), catSearch.getMaxAge()));
                }
                if( catSearch.getStartBirthday() != null ){
                    pList.add(cb.greaterThanOrEqualTo(root.<Date>get("birthday"), catSearch.getStartBirthday()));//大于等于起始日期
                }
                if( catSearch.getEndBirthday() != null ){
                    pList.add(cb.lessThanOrEqualTo(root.get("birthday").as(Date.class), catSearch.getEndBirthday()));//小于等于截止日期
                }
                Predicate[] pre = new Predicate[pList.size()];
                return query.where(pList.toArray(pre)).getRestriction();
			}

        };
    }
	
    
    
    
    
    /** 
	 * 查询条件动态组装
	 * 匿名内部类形式
	 */  
	private Specification<Cat> queryCatByDynamicWhere(final String name,final String sex,final Integer age,final Date startDate,final Date endDate){
	    return new Specification<Cat>() {

			@Override
			public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				Predicate predicate = criteriaBuilder.conjunction();				
				List<Expression<Boolean>> expressionList = predicate.getExpressions();//动态SQL表达式集合
				if( name != null && !"".equals(name) ){
					expressionList.add(
	                        criteriaBuilder.and(root.<String>get("name").in(name))
	                );
//					predicateList.add(criteriaBuilder.and(root.<String>get("name").in(name)));
				}
				if( sex != null && !"".equals(sex) ){
					expressionList.add(
	                        criteriaBuilder.and(root.<String>get("sex").in(sex))
	                );
				}
				if( age != null){
					expressionList.add(
							criteriaBuilder.and(root.<String>get("age").in(age))
					);
				}
                if( startDate != null && endDate != null ){
                	predicate.getExpressions().add(
                            criteriaBuilder.between(root.<Date>get("birthday"), startDate, endDate)
                    );
                }
//                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
//                return criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()])).getRestriction();
                return predicate;
            }

	    };
	      
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
