// src/TrainerDetail.jsx
import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from './TrainersMock';

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainersMock.find((t) => t.trainerId === id);

  if (!trainer) {
    return <p>Trainer not found.</p>;
  }

  return (
    <div>
      <h2>Trainer Detail</h2>
      <p><strong>ID:</strong> {trainer.trainerId}</p>
      <p><strong>Name:</strong> {trainer.name}</p>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong></p>
      <ul>
        {trainer.skills.map((skill, idx) => (
          <li key={idx}>{skill}</li>
        ))}
      </ul>
    </div>
  );
}

export default TrainerDetail;
