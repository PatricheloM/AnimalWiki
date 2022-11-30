import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../style/SearchBar.css";

export default function App() {
  const navigate = useNavigate();
  const [value, setValue] = useState("");
  const [title, setTitle] = useState("");

  let data = [];
  for (let i = 0; i < title.length; i++) {
    let obj = title[i];

    console.log(obj);
    data.push(obj);
  }
  useEffect(() => {
    async function getStoreData() {
      const response = await axios.get("http://localhost:8080/api/animal");
      setTitle(response.data);
      console.log(response.data);
    }
    getStoreData();
  }, []);

  const onChange = (event) => {
    setValue(event.target.value);
  };

  const onSearch = (searchTerm) => {
    setValue(searchTerm);
    // our api to fetch the search result
    console.log("search ", searchTerm);
    navigate(`/animal/${searchTerm}`);
  };

  return (
    <div className="App">
      <div className="search-container">
        <div className="search-inner">
          <input type="text" value={value} onChange={onChange} />
          <button onClick={() => onSearch(value)}> Search </button>
        </div>
        <div className="dropdown">
          {data
            .filter((item) => {
              const searchTerm = value.toLowerCase();
              const name = item.name.toLowerCase();

              return (
                searchTerm && name.includes(searchTerm) && name !== searchTerm
              );
            })
            .slice(0, 10)
            .map((item) => (
              <div
                onClick={() => onSearch(item.name)}
                className="dropdown-row"
                key={item.name}
              >
                {item.name}
              </div>
            ))}
        </div>
      </div>
    </div>
  );
}
