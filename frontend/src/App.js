import MainPage from "./Components/MainPage";
import Specie from "./Components/Specie";
import Animal from "./Components/Animal";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainPage />} />
          <Route path="/:specie" element={<Specie />} />
          <Route path="/type/:animal" element={<Animal />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
