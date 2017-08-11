package com.example.demo.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.json.util.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "entity")
public class Journal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String summary;
	private Date created;

	@Transient
	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public Journal(String title, String summary, String created) throws ParseException {
		this.title = title;
		this.summary = summary;
		this.created = format.parse(created);
	}

	public Journal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@JsonIgnore
	public String getCreatedAsShort() {
		return format.format(created);
	}
	
	@Override
	public String toString() {
		return "Journal [id=" + id + ", title=" + title + ", summary=" + summary + ", created=" + created + "]";
	}
}
