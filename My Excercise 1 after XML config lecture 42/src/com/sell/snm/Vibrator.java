package com.sell.snm;

public class Vibrator implements SnMProducts {
	private RandomThoughtsService randomThoughtService;
	
	private Integer proce;
	private String desc;

	public Integer getProce() {
		return proce;
	}


	public String[] getRandomThoughtService() {
		return randomThoughtService.getRandomThought();
	}


	public void setRandomThoughtService(RandomThoughtsService randomThoughtService) {
		this.randomThoughtService = randomThoughtService;
	}

	public void setProce(Integer proce) {
		this.proce = proce;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	@Override
	public String getProductCategory() {
		
		return "Inside Vibrator getProductCategoryMethod";
		
	}

}
