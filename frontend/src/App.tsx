import Header from "./components/Header";
import CardeVendas from "./components/CardeVendas";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
  return (
    <>
      <ToastContainer />
      <Header />
      <main>
        <section id="vendas">
          <div className="dsmeta-container">
            <CardeVendas />
          </div>
        </section>
      </main>
    </>
  )
}

export default App;
