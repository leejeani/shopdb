package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MarkerDTO {
	private int id;
	private String title;
	private String target;
	private float lat;
	private float lng;
	private String loc;
	private String img;
}
