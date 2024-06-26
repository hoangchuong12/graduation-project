import React from 'react';
import '../../assets/styles/productfortune.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart, faStar, faBars, faTh  } from '@fortawesome/free-solid-svg-icons';




const Productfortune = () => {
    return (
    <div>
    <section className>
        <div className="container">
        <div className="row">
            {/* sidebar */}
            <div className="col-lg-3">
            {/* Toggle button */}
            <button className="btn btn-outline-secondary mb-3 w-100 d-lg-none" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span>Show filter</span>
            </button>
            {/* Collapsible wrapper */}
            <div className="collapse card d-lg-block mb-5" id="navbarSupportedContent">
                <div className="accordion" id="accordionPanelsStayOpenExample">
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingOne">
                    <button className="accordion-button text-dark bg-light" type="button" data-mdb-toggle="collapse" data-mdb-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                        Related items
                    </button>
                    </h2>
                    <div id="panelsStayOpen-collapseOne" className="accordion-collapse collapse show" aria-labelledby="headingOne">
                    <div className="accordion-body">
                        <ul className="list-unstyled">
                        <li><a href="#" className="text-dark">Electronics </a></li>
                        <li><a href="#" className="text-dark">Home items </a></li>
                        <li><a href="#" className="text-dark">Books, Magazines </a></li>
                        <li><a href="#" className="text-dark">Men's clothing </a></li>
                        <li><a href="#" className="text-dark">Interiors items </a></li>
                        <li><a href="#" className="text-dark">Underwears </a></li>
                        <li><a href="#" className="text-dark">Shoes for men </a></li>
                        <li><a href="#" className="text-dark">Accessories </a></li>
                        </ul>
                    </div>
                    </div>
                </div>
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingTwo">
                    <button className="accordion-button text-dark bg-light" type="button" data-mdb-toggle="collapse" data-mdb-target="#panelsStayOpen-collapseTwo" aria-expanded="true" aria-controls="panelsStayOpen-collapseTwo">
                        Brands
                    </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" className="accordion-collapse collapse show" aria-labelledby="headingTwo">
                    <div className="accordion-body">
                        <div>
                        {/* Checked checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckChecked1" defaultChecked />
                            <label className="form-check-label" htmlFor="flexCheckChecked1">Mercedes</label>
                            <span className="badge badge-secondary float-end">120</span>
                        </div>
                        {/* Checked checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckChecked2" defaultChecked />
                            <label className="form-check-label" htmlFor="flexCheckChecked2">Toyota</label>
                            <span className="badge badge-secondary float-end">15</span>
                        </div>
                        {/* Checked checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckChecked3" defaultChecked />
                            <label className="form-check-label" htmlFor="flexCheckChecked3">Mitsubishi</label>
                            <span className="badge badge-secondary float-end">35</span>
                        </div>
                        {/* Checked checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckChecked4" defaultChecked />
                            <label className="form-check-label" htmlFor="flexCheckChecked4">Nissan</label>
                            <span className="badge badge-secondary float-end">89</span>
                        </div>
                        {/* Default checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" />
                            <label className="form-check-label" htmlFor="flexCheckDefault">Honda</label>
                            <span className="badge badge-secondary float-end">30</span>
                        </div>
                        {/* Default checkbox */}
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" />
                            <label className="form-check-label" htmlFor="flexCheckDefault">Suzuki</label>
                            <span className="badge badge-secondary float-end">30</span>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingThree">
                    <button className="accordion-button text-dark bg-light" type="button" data-mdb-toggle="collapse" data-mdb-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                        Price
                    </button>
                    </h2>
                    <div id="panelsStayOpen-collapseThree" className="accordion-collapse collapse show" aria-labelledby="headingThree">
                    <div className="accordion-body">
                        <div className="range">
                        <input type="range" className="form-range" id="customRange1" />
                        </div>
                        <div className="row mb-3">
                        <div className="col-6">
                            <p className="mb-0">
                            Min
                            </p>
                            <div className="form-outline">
                            <input type="number" id="typeNumber" className="form-control" />
                            <label className="form-label" htmlFor="typeNumber">$0</label>
                            </div>
                        </div>
                        <div className="col-6">
                            <p className="mb-0">
                            Max
                            </p>
                            <div className="form-outline">
                            <input type="number" id="typeNumber" className="form-control" />
                            <label className="form-label" htmlFor="typeNumber">$1,0000</label>
                            </div>
                        </div>
                        </div>
                        <button type="button" className="btn btn-white w-100 border border-secondary">apply</button>
                    </div>
                    </div>
                </div>
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingThree">
                    <button className="accordion-button text-dark bg-light" type="button" data-mdb-toggle="collapse" data-mdb-target="#panelsStayOpen-collapseFour" aria-expanded="false" aria-controls="panelsStayOpen-collapseFour">
                        Size
                    </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFour" className="accordion-collapse collapse show" aria-labelledby="headingThree">
                    <div className="accordion-body">
                        <input type="checkbox" className="btn-check border justify-content-center" id="btn-check1" defaultChecked autoComplete="off" />
                        <label className="btn btn-white mb-1 px-1" style={{width: 60}} htmlFor="btn-check1">XS</label>
                        <input type="checkbox" className="btn-check border justify-content-center" id="btn-check2" defaultChecked autoComplete="off" />
                        <label className="btn btn-white mb-1 px-1" style={{width: 60}} htmlFor="btn-check2">SM</label>
                        <input type="checkbox" className="btn-check border justify-content-center" id="btn-check3" defaultChecked autoComplete="off" />
                        <label className="btn btn-white mb-1 px-1" style={{width: 60}} htmlFor="btn-check3">LG</label>
                        <input type="checkbox" className="btn-check border justify-content-center" id="btn-check4" defaultChecked autoComplete="off" />
                        <label className="btn btn-white mb-1 px-1" style={{width: 60}} htmlFor="btn-check4">XXL</label>
                    </div>
                    </div>
                </div>
                <div className="accordion-item">
                    <h2 className="accordion-header" id="headingThree">
                    <button className="accordion-button text-dark bg-light" type="button" data-mdb-toggle="collapse" data-mdb-target="#panelsStayOpen-collapseFive" aria-expanded="false" aria-controls="panelsStayOpen-collapseFive">
                        Ratings
                    </button>
                    </h2>
                    <div id="panelsStayOpen-collapseFive" className="accordion-collapse collapse show" aria-labelledby="headingThree">
                    <div className="accordion-body">
                        {/* Default checkbox */}
                        <div className="form-check">
                        <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" defaultChecked />
                        <label className="form-check-label" htmlFor="flexCheckDefault">
                        <FontAwesomeIcon icon={faStar} />
                        </label>
                        </div>
                        {/* Default checkbox */}
                        <div className="form-check">
                        <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" defaultChecked />
                        <label className="form-check-label" htmlFor="flexCheckDefault">
                        <FontAwesomeIcon icon={faStar} />    <FontAwesomeIcon icon={faStar} />   
                        </label>
                        </div>
                        {/* Default checkbox */}
                        <div className="form-check">
                        <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" defaultChecked />
                        <label className="form-check-label" htmlFor="flexCheckDefault">
                        <FontAwesomeIcon icon={faStar} />   <FontAwesomeIcon icon={faStar} />   <FontAwesomeIcon icon={faStar} />
                        </label>
                        </div>
                        {/* Default checkbox */}
                        <div className="form-check">
                        <input className="form-check-input" type="checkbox" defaultValue id="flexCheckDefault" defaultChecked />
                        <label className="form-check-label" htmlFor="flexCheckDefault">
                        <FontAwesomeIcon icon={faStar} />   <FontAwesomeIcon icon={faStar} />    <FontAwesomeIcon icon={faStar} />
                        </label>
                        </div>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            </div>
            {/* sidebar */}
            {/* content */}
            <div className="col-lg-9">
            <header className="d-sm-flex align-items-center border-bottom mb-4 pb-3">
                <strong className="d-block py-2">32 Items found </strong>
                <div className="ms-auto">
                <select className="form-select d-inline-block w-auto border pt-1">
                    <option value={0}>Best match</option>
                    <option value={1}>Recommended</option>
                    <option value={2}>High rated</option>
                    <option value={3}>Randomly</option>
                </select>
                <div className="btn-group shadow-0 border">
                    <a href="#" className="btn btn-light" title="List view">
                    <FontAwesomeIcon icon={faBars} /> 
                    </a>
                    <a href="#" className="btn btn-light active" title="Grid view">
                    <FontAwesomeIcon icon={faTh} /> 
                    </a>
                </div>
                </div>
            </header>
            <div className="row">
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <div className="d-flex flex-row">
                        <h5 className="mb-1 me-1">$34,50</h5>
                        <span className="text-danger"><s>$49.99</s></span>
                    </div>
                    <p className="card-text">T-shirts with multiple colors, for men and lady</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>


                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/11.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$120.00</h5>
                    <p className="card-text">Winter Jacket for Men and Women, All sizes</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/12.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$120.00</h5>
                    <p className="card-text">T-shirts with multiple colors, for men and lady</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/13.webp" className="card-img-top" style={{aspectRatio: '1 / 1'}} />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$120.00</h5>
                    <p className="card-text">Blazer Suit Dress Jacket for Men, Blue color</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/14.webp" className="card-img-top" style={{aspectRatio: '1 / 1'}} />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$510.00</h5>
                    <p className="card-text">Slim sleeve wallet Italian leather - multiple colors</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/10.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$79.99</h5>
                    <p className="card-text">T-shirts with multiple colors, for men and lady</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/11.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$120.00</h5>
                    <p className="card-text">Winter Jacket for Men and Women, All sizes</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/12.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$120.00</h5>
                    <p className="card-text">T-shirts with multiple colors, for men and lady</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
                <div className="col-lg-4 col-md-6 col-sm-6 d-flex">
                <div className="card w-100 my-2 shadow-2-strong">
                    <img src="https://bootstrap-ecommerce.com/bootstrap5-ecommerce/images/items/9.webp" className="card-img-top" />
                    <div className="card-body d-flex flex-column">
                    <h5 className="card-title">$43.50</h5>
                    <p className="card-text">Summer New Men's Denim Jeans Shorts</p>
                    <div className="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">
                        <a href="#!" className="btn btn-primary shadow-0 me-1">Add to cart</a>
                        <a href="#!" className="btn btn-light border icon-hover px-2 pt-2"> <FontAwesomeIcon icon={faHeart} /></a>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            <hr />
            {/* Pagination */}
            <nav aria-label="Page navigation example" className="d-flex justify-content-center mt-3">
                <ul className="pagination">
                <li className="page-item disabled">
                    <a className="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">«</span>
                    </a>
                </li>
                <li className="page-item active"><a className="page-link" href="#">1</a></li>
                <li className="page-item"><a className="page-link" href="#">2</a></li>
                <li className="page-item"><a className="page-link" href="#">3</a></li>
                <li className="page-item"><a className="page-link" href="#">4</a></li>
                <li className="page-item"><a className="page-link" href="#">5</a></li>
                <li className="page-item">
                    <a className="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">»</span>
                    </a>
                </li>
                </ul>
            </nav>
            {/* Pagination */}
            </div>
        </div>
        </div>            
    </section>
    </div>

    );
};

export default Productfortune;