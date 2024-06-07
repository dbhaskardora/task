import React from 'react'


const FilterOption = ({ categories, onChange }) => {
    const handleCategoryChange = event => {
      const category = event.target.value;
      onChange(category);
    };
  
    return (
      <div>
        <label htmlFor="category">Filter by Category:</label>
        <select id="category" onChange={handleCategoryChange}>
          <option value="">All Categories</option>
          {categories.map(category => (
            <option key={category} value={category}>
              {category}
            </option>
          ))}
        </select>
      </div>
    );
  };

export default FilterOption
