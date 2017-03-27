package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import fr.iutinfo.skeleton.common.dto.ImageDto;

public class Image {
	private int id=0;
	private String title;
	private String url;
	private String desc;
	private String date;

	public Image(String title, String url, String desc, String date) {
		this.title=title;
		this.url=url;
		this.desc=desc;
		this.date=date;
	}
	
	public Image() {
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getDesc() {
		return desc;
	}

	public String getDate() {
		return date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void initFromDto(ImageDto dto) {
		this.setId(dto.getId());
		this.setDesc(dto.getDesc());
		this.setUrl(dto.getUrl());
		this.setDate(dto.getDate());
	}

	public ImageDto convertToDto() {
		ImageDto dto = new ImageDto();
		dto.setId(this.getId());
		dto.setDesc(this.getDesc());
		dto.setUrl(this.getUrl());
		dto.setDate(this.getDate());
		return dto;
	}


}
