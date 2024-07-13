import React from 'react';
import Button from '@material/react-button';
import "./CategoryHeader.css"

function CategoryHeader() {
    return (
        <>
            <div className="category-head">
                <ul className='category-option'>
                    <li> <h1 className='header-title'> Categories </h1> </li>
                    <li> <Button variant="contained" size="large">Contained</Button> </li>
                </ul>
            </div>
        </>
    )

}

export default CategoryHeader;