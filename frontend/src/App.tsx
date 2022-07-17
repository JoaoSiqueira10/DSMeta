import Header from "./components/Header";
import CardeVendas from "./components/CardeVendas";


function App() {
  return (
    <>
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
