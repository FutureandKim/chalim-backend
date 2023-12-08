package com.chalim.backend.dto.translate;

import java.util.List;

public class ResponseDto {
    private String imageName;
    private List<MenuNameItem> menuName;
    private List<PriceItem> price;

    public ResponseDto() {
    }

    public ResponseDto(String imageName, List<MenuNameItem> menuName, List<PriceItem> price) {
        this.imageName = imageName;
        this.menuName = menuName;
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<MenuNameItem> getMenuName() {
        return menuName;
    }

    public void setMenuName(List<MenuNameItem> menuName) {
        this.menuName = menuName;
    }

    public List<PriceItem> getPrice() {
        return price;
    }

    public void setPrice(List<PriceItem> price) {
        this.price = price;
    }
}
