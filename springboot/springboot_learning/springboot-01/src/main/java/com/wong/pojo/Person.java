package com.wong.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
@ConfigurationProperties(prefix = "person")
// load 指定配置文件
//@PropertySource(value = "classpath:person.properties")
@Validated // 數據校驗
public class Person {
	// SPEL表達是取出配置文件中的值
//	@Value("${name}")
	private String name;
	@NonNull
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
    
    public Person() {}
    
	public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists,
			Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.happy = happy;
		this.birth = birth;
		this.maps = maps;
		this.lists = lists;
		this.dog = dog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getHappy() {
		return happy;
	}

	public void setHappy(Boolean happy) {
		this.happy = happy;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public List<Object> getLists() {
		return lists;
	}

	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", happy=" + happy + ", birth=" + birth + ", maps=" + maps
				+ ", lists=" + lists + ", dog=" + dog + "]";
	}
    
    
}
