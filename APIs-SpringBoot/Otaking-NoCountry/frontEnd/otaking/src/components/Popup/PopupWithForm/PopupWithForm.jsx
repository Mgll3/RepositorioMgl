'use client'
import { useGlobalContext } from '@/context/store'
import Popup from '../Popup'
import './PopupWithForm.css'

export default function PopupWithForm({isOpen, children, title, onSubmit}) {
  const { closeAllPopups } = useGlobalContext()

  function handleSubmit(e) {
    e.preventDefault()
    onSubmit()
  }

  return <Popup isOpen={isOpen}>
    <form className={`form`} noValidate name={title} onSubmit={handleSubmit} >
      <h3 className="form__title">{title}</h3>
      <fieldset className='form__field'>
        {children}
      </fieldset>
      <menu className='form__menu'>
        <button type='submit' className='form__btn form__btn_type_sbm'>{title}</button>
        <button type='button' className='form__btn form__btn_type_cl' onClick={() => closeAllPopups()}>Cancelar</button>
      </menu>
    </form>
  </Popup>
}