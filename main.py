from fastapi import FastAPI
import tensorflow as tf
from tensorflow.keras.models import load_model
from datetime import datetime, timedelta
import numpy as np

app = FastAPI()

@app.get("/halo")
async def root():
    return {"message": "Hello World"}

@app.post("/predict")
async def prediksi_ovulasi(
    tanggal_mulai: str,
    panjang_siklus: int
):
    # Mengonversi input tanggal menjadi objek datetime
    tanggal_mulai_dt = datetime.strptime(tanggal_mulai, '%Y-%m-%d')

    # Buat fitur yang diperlukan untuk prediksi menggunakan model LSTM
    features = []
    for i in range(3):
        features.append([panjang_siklus - (i * 2), panjang_siklus - (i * 2)])

    features = np.array(features).reshape(1, 3, 2)

    # Prediksi panjang siklus dan periode berikutnya menggunakan model LSTM
    prediksi = model.predict(features)
    prediksi_siklus_berikutnya = int(prediksi[0, 0])
    prediksi_periode_berikutnya = int(prediksi[0, 1])

    # Menghitung hari ovulasi
    hari_ovulasi = prediksi_siklus_berikutnya

    # Menghitung tanggal ovulasi untuk bulan depan
    tanggal_mulai_bulan_depan = tanggal_mulai_dt.replace(day=28) + timedelta(days=4)  # untuk menghindari bulan yang lebih pendek
    tanggal_mulai_bulan_depan = tanggal_mulai_bulan_depan - timedelta(days=tanggal_mulai_bulan_depan.day) + timedelta(days=tanggal_mulai_dt.day)
    tanggal_ovulasi_bulan_depan = tanggal_mulai_bulan_depan + timedelta(days=hari_ovulasi)

    return {"message": "success", "data": tanggal_ovulasi_bulan_depan.date()}

def load_keras_model(model_path):
    """
    Load a Keras model from a .h5 file.

    Args:
    model_path (str): Path to the .h5 model file.

    Returns:
    model: Loaded Keras model.
    """
    try:
        model = load_model(model_path)
        print("Model loaded successfully.")
        return model
    except Exception as e:
        print(f"Error loading model: {e}")
        return None

# Example usage:
model = load_keras_model('lstm_model.h5')
