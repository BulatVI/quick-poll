package com.example.quick_poll.client;

import java.util.List;

public class PageWrapper<T>{
	
    // Page's content
	private List<T> content;
	
	private Boolean last;
	private Boolean first;
	private Integer totalPages;
	private Integer totalElements;
	private Integer size;
	private Integer number;
	private Integer numberOfElements;
	private SortWrapper sort;
	
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	public Boolean getFirst() {
		return first;
	}
	public void setFirst(Boolean first) {
		this.first = first;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}
	public int getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public int getNumberOfElements() {
		return numberOfElements;
	}
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public SortWrapper getSort() {
		return sort;
	}
	public void setSort(SortWrapper sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "PageImplWrapper [last=" + last + ", first=" + first
				+ ", totalPages=" + totalPages + ", totalElements="
				+ totalElements + ", size=" + size + ", number=" + number
				+ ", numberOfElements=" + numberOfElements + ", content="
				+ content + ", sort=" + sort + "]";
	}
}
