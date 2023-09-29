
import { Component } from '@angular/core';
import './page1.component.scss';



@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.scss']
})
export class Page1Component {
  entries = [
    { id: 1, name: 'John Doe', email: 'john@example.com' },
    { id: 2, name: 'Jane Doe', email: 'jane@example.com' }
    // Add more entries as needed
  ];

  currentPage = 1;
  totalPages = 2; // Assuming 2 pages for this example

  newEntry = { name: '', email: '' };

  loadPreviousPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }

  loadNextPage() {
    if (this.currentPage < this.totalPages) {
      this.currentPage++;
    }
  }

  addEntry() {
    this.entries.push({
      id: this.entries.length + 1,
      name: this.newEntry.name,
      email: this.newEntry.email
    });
    this.newEntry = { name: '', email: '' };
  }

  editEntry(entry: any) {
    // Your code here
  }
  
}
