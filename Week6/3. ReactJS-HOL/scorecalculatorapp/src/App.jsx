import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name="Asir Praveen A"
        School="Bell Matriculation School"
        total={485}
        goal={500}
      />
    </div>
  );
}

export default App;
