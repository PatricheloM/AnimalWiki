import MainPage from "./Components/MainPage";
import Specie from "./Components/Specie";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/:specie" element={<Specie />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
