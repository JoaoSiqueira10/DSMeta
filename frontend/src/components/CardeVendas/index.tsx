import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import NotificationButton from '../NotificationButton';
import './styles.css';

function CardeVendas() {

    //data com 1 ano atras
    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date();

    const [minData, setMinData] = useState(min);
    const [maxData, setMaxData] = useState(max);
    
    useEffect(() => {
        axios.get("http://localhost:8080/sales").then(response => {
            console.log(response.data);
        });
    },[]);

    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-vendas-titulo">Vendas</h2>
            <div>
                <div className="dsmeta-form-controle-container">
                    <DatePicker
                        selected={minData}
                        onChange={(date: Date) => setMinData(date)}
                        className="dsmeta-form-controle"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
                <div className="dsmeta-form-controle-container">
                    <DatePicker
                        selected={maxData}
                        onChange={(date: Date) => setMaxData(date)}
                        className="dsmeta-form-controle"
                        dateFormat="dd/MM/yyyy"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-tabela-vendas">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td className="show992">#341</td>
                            <td className="show576">08/07/2022</td>
                            <td>Anakin</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 55400.00</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">#341</td>
                            <td className="show576">08/07/2022</td>
                            <td>Anakin</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 55400.00</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td className="show992">#341</td>
                            <td className="show576">08/07/2022</td>
                            <td>Anakin</td>
                            <td className="show992">15</td>
                            <td className="show992">11</td>
                            <td>R$ 55400.00</td>
                            <td>
                                <div className="dsmeta-red-btn-container">
                                    <NotificationButton />
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default CardeVendas;