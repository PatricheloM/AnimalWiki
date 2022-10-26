import React from "react";
import logo from "../Logo/logo-no-background.png";
import "../style/MainPage.css";

export default function MainPage() {
  let items = [
    "Porcos Halak",
    "Csontos Halak",
    "Kétéltüek",
    "Hüllők",
    "Madarak",
    "Emlősök",
  ];
  let itemList = [];
  items.forEach((item, index) => {
    itemList.push(<li key={index}>{item}</li>);
  });
  return (
    <div className="container">
      <div className="firstLine">
        <img src={logo} alt="Logo" />;<ul className="firstUl">{itemList}</ul>
      </div>
      <div className="secondLine">
        <div class="search__container">
          <input class="search__input" type="text" placeholder="Search" />
        </div>
      </div>
    </div>
  );
}
