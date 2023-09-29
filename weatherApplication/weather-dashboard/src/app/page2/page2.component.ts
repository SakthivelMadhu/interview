import { Component } from '@angular/core';
import './page2.component.scss';
@Component({
  selector: 'app-page2',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.scss']
})
export class Page2Component {
  weatherData = [
    { city: 'Delhi', temperature: 30 },
    { city: 'Mumbai', temperature: 28 },
    { city: 'Bangalore', temperature: 27 }
    // Add more weather data as needed
  ];
}
