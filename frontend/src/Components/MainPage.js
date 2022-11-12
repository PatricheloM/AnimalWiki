import logo from "../Logo/logo-no-background.png";
import "../style/MainPage.css";
import axios from "axios";
import { useEffect, useState } from "react";

let items = [];

const getResponse = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/type");
    items = response.data;
    console.log(items);
  } catch (err) {
    console.log("err");
  }
};

getResponse();

export default function MainPage() {
  let itemList = [];
  items.forEach((item, index) => {
    itemList.push(<li key={index}>{item}</li>);
  });
  const [title, setTitle] = useState([]);
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get("http://localhost:8080/api/type");
      setTitle(response.data);
    }
    getStoreData();
  }, []);
  return (
    <div className="container">
      <div className="firstLine">
        <img src={logo} alt="Logo" />;<ul className="firstUl">{itemList}</ul>
      </div>
      <div className="secondLine">
        <div className="search__container">
          <input className="search__input" type="text" placeholder="Search" />
        </div>
      </div>
    </div>
  );
}
